#include "grid.h"
#include <assert.h>
#include <stdio.h>
#include <string.h>

void grid_update_value(Grid_T *g, int i, int j, int n) {
    assert(g);
    assert (n>=0 && n<=10);
    g->elts[i][j].val = n;
}

int grid_read_value(Grid_T g, int i, int j){
    assert(&g != NULL);
    return(g.elts[i][j].val);
}

void grid_set_choice(Grid_T *g, int i, int j, int n){
    assert(g);
    g->elts[i][j].choices.num[n] = 1;
    
}

void grid_clear_choice(Grid_T *g, int i, int j, int n){
    assert(g);
    g->elts[i][j].choices.num[n] = 0;
}

int grid_choice_is_valid(Grid_T g, int i, int j, int n){
    assert(&g != NULL);
    return (g.elts[i][j].choices.num[n]);
}

void grid_remove_choice(Grid_T *g, int i, int j, int n){
    assert(g);
   if (grid_choice_is_valid( *g,  i, j,  n) == 1) {
           g->elts[i][j].choices.count--;
           g->elts[i][j].choices.num[n] = 0;   
  }    
        
}

int grid_read_count(Grid_T g, int i, int j){
    assert(&g != NULL);
    return g.elts[i][j].choices.count;
}

void grid_set_count(Grid_T *g, int i, int j){
    assert(g);
    g->elts[i][j].choices.count = 9;
}

void grid_clear_count(Grid_T *g, int i, int j){
    assert(g);
    g->elts[i][j].choices.count = 0;
}

int grid_read_unique(Grid_T g){
    assert(&g != NULL);
    return g.unique;
}

void grid_set_unique(Grid_T *g){
    assert(g);
    g->unique = 1;
}

void grid_clear_unique(Grid_T *g){
    assert(g);
    g->unique = 0;
}




