#include <iostream>
using namespace std;

class Sort{
public:
    void swap(int &a, int &b){
        int temp = a;
        a = b;
        b = temp;
    
    }
    void maxMen(int *list, int node, int len)
    {
        int left = node * 2 + 1; 
        while (left < len) {
            if (left+1 < len && list[left] < list[left+1]) 
                left++;

            if ( list[node] >= list[left]) {
                return;
            }
           
           this->swap(list[node], list[left]);
           node = left;
           left = left * 2 + 1;
        }
    }
   void heapSort(int *list, int len ){
       /* 调整堆 */    
       int i;
       for (i = len/2;i >=0; i--)
           this->maxMen(list, i, len);
       
       for (i = len-1; i > 0; i--) {
           this->swap(list[0], list[i]);
           this->maxMen(list, 0, i);
       }
   }
  
   void  echoList(int *list, int len){
        for(int i=0;i < len; i++) 
            cout << list[i] << "  ";
        cout << endl;
   
   }

};
int main()
{
    int list[] = {1, 10, 12, 35, 3};
    Sort *s = new Sort();    
    s->heapSort(list, 5);
    s->echoList(list, 5);
}
