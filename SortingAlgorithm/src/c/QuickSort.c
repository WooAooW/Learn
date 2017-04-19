
#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#define  LENGTH 10
#define  true  1
#define  false  0

/*
 * Quick Sort 
 * Core thing： Recursive find the  suitable position 
 * Comment: implement by myself but is is too bad not clsscial
 * */
void  QuickSort(int list[], int left, int right)
{
    int i = left;
    int j = right;
    int temp = 0;
    int temp_swap = 0;
    temp = list[left];

    while( left < right)
    {

        /* <= handing the equal case */
        while(left <= right && temp >= list[left]) 
            left++;

        /* if the left is the largest value ,left will cross the right border*/
        if(left > j)          
            left =j;

        while(left <= right && temp <= list[right])
            right--;
        /* if the right is the largest value ,right will cross the blef torder */
         if(right +1 ==  left) 
             left = right;

        /* put the smaller than temp to left ,the biggger than to right */
        if(left < right)  
        {   
            temp_swap = list[right];
            list[right] = list[left];
            list[left] = temp_swap;
            left++;
            right--;
        }else if(left == right ){
            list[i] = list[left];
            list[left] = temp;
            QuickSort(list, i, left-1);
            QuickSort(list, left+1, j);
        }

    }


}

/*
 * Classic implement QuickSort 
 * Core thing : compare from end in array
 * parameter : 
 * list is a int array for sorting 
 * left is the sort start index(start from 0 )
 * right is the sort end index
 * */
void QuickSort_class(int list[], int left, int right)
{
    int l = left;
    int r = right;
    int temp = 0;
if(left < right ) 
{
    temp = list[left];
    while(l < r)  /* compara all value in list until find final position */
    {

        while(r>l && list[r]>temp) /* find a smaller than temp  */
                r--;
        /* the bigger than temp can be stored to list[l] 
         * because the temp store the list[l]
         * the list[l]  is the  fist postion  smaller than temp 
         */
            if(r > l) 
            {
                list[l]= list[r];
                l++;
            }
             
            while(l<r && list[l]<temp) 
                l++;
            if  (l < r)
            {
                list[r] = list[l];
                r--;
            }  
        }
    list[l] = temp;
    QuickSort_class(list, left, l-1);
    QuickSort_class(list, l+1, right);
    }    
}
/* create a  array in heap memrory
 * parameter : length is the sizeof array
 * return :  return the address of array
 * */
int*  CreateList(int length)
{   
    int *list  = (int *)malloc(sizeof(int) *  length);
    srand(time(NULL));
    int i;
    for(i = 0; i < LENGTH; i++)    
        list[i] = rand()%50;

    return list;
}
void list_for_each(int * list, int length)
{
    int i;
    for(i = 0; i < length; i++)
        printf("%d ", list[i]);
    printf(" \n");
}


int main()
{
    int *list = CreateList(LENGTH);
    list_for_each(list, LENGTH);
    QuickSort_class(list, 0, LENGTH -1);
    list_for_each(list, LENGTH);
    return 0;
}


