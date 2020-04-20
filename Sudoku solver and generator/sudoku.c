#include "sudoku.h"
#include <ctype.h>
#include <assert.h>




Grid_T sudoku_read(void){
Grid_T g2 ;
int i=0,j=0,num,count;
  
 while (i<9){
     if(j==9){
         i++;
         j=0;
         continue;
     }
     scanf("%d",&num);
     
     if (num<0|| num>9){
         printf("Wrong input\n");
         exit(EXIT_FAILURE);
     }
     grid_update_value(&g2,i,j,num);
     j++;
     count ++;
     }
    if (count != 81)
    printf("Not all the blocks are completed\n");
 
  return g2;  
}

int sudoku_blanks(Grid_T g){
    int i,j,blanks=0;
    for (i=0; i<9; i++){
        for (j=0; j<9; j++){
             if (grid_read_value(g,i,j)==0)
             blanks++;
        }
    }
    return blanks;
}

void sudoku_print(FILE *s, Grid_T g){
   int i=0,j=0; 
     
    for (i=0; i<9; i++) {
       for (j=0; j<9; j++){
     fprintf(s,"%d ",grid_read_value(g,i,j));      
       }
       fprintf(s,"\n");
    }
    return;
}



int errors(Grid_T g,int correct){
 int er=0,i=0,j=0,k=0,num,t;  
 for (i=0; i<9; i++){
     for (j=0; j<9; j++){
         num = grid_read_value(g,i,j);
         /* if this number is not entered yet, continue*/
         if (num == 0) {continue;}  
         
         for (t=0; t<9; t++){
             /* check lines (k represents collumns)*/
             /* if t == j ,I have visited the number in row one time */
             if (num == grid_read_value(g,i,t) && t != j ){
                     er = 1;
                     if (correct == 1){
                     printf("Error (line) in elements (%d,%d) - (%d,%d),in value %d\n",i,j,i,t,num);
                         }
                     }
             /* check collumns (k represents lines)*/
             /* if t == i ,I have visited the number in collumn one time */
             if (num == grid_read_value(g,t,j) && t != i ){
                     er = 1;
                     if (correct == 1){
                     printf("Error (collumn) in elements (%d,%d) - (%d,%d),in value %d\n",i,j,t,j,num);
             }
          }
         }
         
           /* check blocks */
           for (t=(i/3)*3; t<(i/3)*3+3; t++) {
               for (k=(j/3)*3; k<(j/3)*3+3; k++) {
                   if (((t != i) ^ (k != j)) &&  num == grid_read_value(g,t,k)){
                       er = 1;
                       if (correct == 1){
                       printf("Error (block) in elements (%d,%d) - (%d,%d),in value %d\n",i,j,t,k,num);
               }
             }
          } 
       }
     }
   }
 
 return er;
}
 
 
 
 void sudoku_print_errors(Grid_T g){
  int correct = 1;
  errors(g,correct);
 }
 
 
 int sudoku_is_correct(Grid_T g){
   int i,j,bl=0,num;
     /* count uncompleted cells*/
     for (i=0; i<9; i++){
         for (j=0; j<9; j++){
             num = grid_read_value(g,i,j);
             if (num == 0) bl++;
         }
     }
     if (errors(g,0) == 0) {
    return 1;
     }
   return 0; 
 }
   

int sudoku_solution_is_unique(Grid_T g){
    if (grid_read_unique(g) == 1)
    return 1;
    else return 0;
}



 static void read_line(Grid_T *g,int i,int j){
     int k=0,value;
     for (k=0; k<9; k++){
        value = grid_read_value(*g,i,k);
         if (value != 0) {
            grid_clear_choice(g,i,j,value);
            g->elts[i][j].choices.count--;
         }
     }
     
     
 }

static void read_column(Grid_T *g,int i,int j){
    int k=0,value;
    for (k=0; k<9; k++){
          value = grid_read_value(*g,k,j);
          if (value != 0){
          if (grid_choice_is_valid(*g,i,j,value) == 1){
               grid_clear_choice(g,i,j,value);
               g->elts[i][j].choices.count--;
          }
       }
    }
}

static void read_block(Grid_T *g,int r,int c){
    int i=0,j=0,value;
    for (i=(r/3)*3; i<(r/3)*3+3; i++){
            for (j=(c/3)*3; j<(c/3)*3+3; j++){
                  value = grid_read_value(*g,i,j);
                     if (value != 0){
                       if (grid_choice_is_valid(*g,r,c,value) == 1){
                           grid_clear_choice(g,r,c,value);
                           g->elts[r][c].choices.count--;
                        }
                     }       
            }
     }
} 

static void sudoku_eliminate_choice(Grid_T *g){
    int i,j;
    for (i=0; i<9; i++){
        for (j=0; j<9; j++){
           if (grid_read_value(*g,i,j) == 0){
                   read_line(g,i,j);
                   read_column(g,i,j);
                   read_block(g,i,j);
           }
        }
    }
}


/* Finds every possible choice if each cell, based on rows ,columns and subgrid*/
static void sudoku_init_choices(Grid_T *g){
    int i=0,j=0,k=0;
   for (i=0; i<9; i++){
        for (j=0; j<9; j++){
            if (grid_read_value(*g,i,j) == 0) {
                grid_set_count(g,i,j);
                for (k=1; k<10; k++)
                    grid_set_choice(g,i,j,k);
            }
        }
    }
 sudoku_eliminate_choice(g);
}

/* Fills the cells of sudoku with the only choice available*/
Grid_T sudoku_fill_one_choice_cells(Grid_T g){
    int i,j,k,x;
    while (sudoku_blanks(g)>0) {
        x = sudoku_blanks(g);
      for (i=0; i<9; i++){
        for (j=0; j<9; j++){
            if ((grid_read_value(g,i,j)==0) && (g.elts[i][j].choices.count==1)){
                for (k=1; k<10; k++){
                    if (grid_choice_is_valid(g,i,j,k) == 1)
                    grid_update_value(&g,i,j,k);
                }
            }
        }
      }
       if (x == sudoku_blanks(g)) {
           grid_clear_unique(&g);
           return g;
       }
      sudoku_init_choices(&g);
    }
    grid_set_unique(&g);
    return g;
}



/* Returns a valid choice for the cell [row][column] of the grid g*/ 
static int sudoku_try_next(Grid_T g,int row,int column){
     int num=0;
   
          if (g.elts[row][column].choices.count == 0) {
              return 0;
          }
            while (grid_choice_is_valid(g,row,column,num) == 0) {
              num = rand()%10; 
            }
     return num;
}


/* Function to find the solution of the puzzle, using backtracking.*/
Grid_T *sudoku_update_choice(Grid_T *g){
   int i,j,k,num;
    
   if (sudoku_blanks(*g) == 0) {
       return g;
   }  
   for (i=0; i<9; i++){
       for (j=0; j<9; j++){
           if (grid_read_value(*g,i,j) == 0)
           break;
       }
       if (grid_read_value(*g,i,j) == 0) break;
       else continue;
   }

            for (k=1; k<10; k++){
                 num = k; 
                   if (grid_choice_is_valid(*g,i,j,num)) {
                    grid_update_value(g,i,j,num);
                    sudoku_init_choices(g);
                    /* if sudoku has solution , return the solution*/
                         if (sudoku_update_choice(g)){
                              return g;
                         }
                     grid_clear_choice(g,i,j,num);
                     grid_update_value(g,i,j,0);
                }
            }
            /* else backtrack */
                     return 0;  
}


Grid_T sudoku_solve(Grid_T g){
    Grid_T sud,*solution;
    sudoku_init_choices(&g);
    sud = sudoku_fill_one_choice_cells(g);

    /* If sudoku has unique solution*/
    if (sudoku_blanks(sud) == 0) return sud;
     
    /* If sudoku has multiple solutions */
    if (sudoku_update_choice(&sud)) solution = sudoku_update_choice(&sud); 
    return *solution;
}

/* Function to return a solved puzzle*/
static Grid_T sudoku_generate_complete(void){
    int i,j;
    Grid_T g;

while (1) {
    for (i=0; i<9; i++) {
        for (j=0; j<9; j++){
             grid_update_value(&g,i,j,0);
        }
    }
    sudoku_init_choices(&g);


    for (i=0; i<9; i++){
        for (j=0; j<9; j++){
            grid_update_value(&g,i,j,sudoku_try_next(g,i,j));\
            sudoku_init_choices(&g);
        }
    }
    if (sudoku_is_correct(g) && sudoku_blanks(g)==0) break;
  }
    
  return g;
}



Grid_T sudoku_generate(int nelts){
    int i,j,blanks;
    Grid_T g;
    
    g = sudoku_generate_complete();
    blanks = 81-nelts;
   
    while (blanks>0){
        i = rand()%9;
        j = rand()%9;
        if (grid_read_value(g,i,j)!=0){
            grid_update_value(&g,i,j,0);
            blanks--;
        }
    }
    return g;
}



int main(int argc, char **argv){
    
    Grid_T g , solution;
    int nelts;
    srand(getpid()); 
  
     switch (argc){  
case 1:  
    printf("New puzzle:\n");
    g = sudoku_read();
    fprintf(stderr,"Puzzle:\n");    
    sudoku_print(stderr,g);
    if (!sudoku_is_correct(g)){
         printf("Given sudoku is wrong!\n");
         break;
    }

    solution = sudoku_solve(g);  
    if (sudoku_is_correct(solution)){
        if (sudoku_solution_is_unique(solution))
        fprintf(stderr,"\nSudoku has unique solution:\n");
        else fprintf(stderr,"\nSudoku has (not unique) solution:\n");
        sudoku_print(stderr,solution);
    } else { 
        fprintf(stderr,"Puzzle has no solution\n");
        sudoku_print_errors(g);
    }
    break;
    
case 2:
    if (argv[1][0] == '-' && 
          argv[1][1] == 'c' && 
          argv[1][2] == '\0') {
          g = sudoku_read();    
        if (sudoku_is_correct(g)) {
            fprintf(stderr,"Sudoku is correct!\n");
        }else{
            fprintf(stderr,"Sudoku is not correct\n");
            sudoku_print_errors(g);
        }
    }
    break;

case 3:
     if (argv[1][0] == '-' && argv[1][1] == 'g' && argv[1][5] == '\0'){
        printf("Generating new sudoku..\n");
        nelts = atoi(&argv[1][3]);
        if (argv[1][5] == '\0'){ 
           g = sudoku_generate(nelts);
           sudoku_print(stdout,g);
        }
     }
     break;

case 4:
      if (argv[1][0] == '-' && argv[1][1] == 'g' && argv[1][6] == '-' && argv[1][7] == 'u' && argv[1][8] == '\0'){
           fprintf(stderr,"Generating new sudoku with unique solution..\n");
           nelts = atoi(&argv[1][3]);
           while(sudoku_solution_is_unique(solution)==0 ){
                 g = sudoku_generate(nelts);
                 solution = sudoku_fill_one_choice_cells(g);
           }
           if (sudoku_solution_is_unique(solution)){
               sudoku_print(stdout,g);
           }
           else printf("Something went wrong\n");
       }
       break;
default:
     fprintf(stderr,"Something is wrong with your input\n");
    
}

     return 0;
}
