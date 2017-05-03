#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define LEN 10
#define MaxSize 100
typedef struct  BTNode
{
    int data;
    struct BTNode *lchild;
    struct BTNode *rchild;
}BTNode;
void visit(BTNode *p);
/* first visit tree node */
void preOrder(BTNode *root)
{
    if  (root != NULL)
    {   
        visit(root);
        preOrder(root->lchild);
        preOrder(root->rchild);
    }
}
/* order tarversal */
void inOrder(BTNode *root)
{
    if  (root != NULL)
    {   
        preOrder(root->lchild);
        visit(root);
        preOrder(root->rchild);
    }
}
/* posterior tarversal */
void postOrder(BTNode *root)
{
    if  (root != NULL)
    {   
        preOrder(root->lchild);
        preOrder(root->rchild);
        visit(root);
    }
}

/*define a BTNode quene that  a cycle quene */
BTNode *quene[MaxSize];
int front = 0, rear = 0;
void inQuene(BTNode *q)
{
    rear = (rear + 1)/MaxSize;
    quene[rear] = q;/* into quen; */
}

BTNode* deQuene()
{
    front = (front + 1)/MaxSize;
    return quene[front];
}

/*level traversal */
void levelOrder(BTNode *root)
{
    BTNode *p;
    if  (root != NULL) 
        inQuene(root); 
    while(rear != front) /* until the quene is empty */
    {
        p = deQuene();
        visit(p);
        if  (p->lchild != NULL)
            inQuene(p->lchild);
        if  (p->rchild != NULL)
            inQuene(p->rchild);
    }
}


/* print the BTNode data */
void visit(BTNode *p)
{
    printf("%d  ", p->data);
}
void insertBTNode(int value, BTNode **root)
{   
    if  (*root == NULL)
    {
        *root = (BTNode *)malloc(sizeof(BTNode));
        (*root)->data = value;
        (*root)->lchild = NULL;
        (*root)->rchild = NULL;
        return ;
    }
    if  (value > (*root)->data)
        insertBTNode(value, &(*root)->rchild);
    else 
        insertBTNode(value, &(*root)->lchild);
}

/* create a BTree */
BTNode* createBTree(int arr[], int len)
{
    int i;
    BTNode *root = NULL;
    for (i = 0; i < len; i++)
        insertBTNode(arr[i], &root);

    return root;
}
/* create a  array in heap memrory
 * parameter : length is the sizeof array
 * return :  return the address of array 
 * */
int*  CreateList(int length)
{   
    int *list  = (int *)malloc(sizeof(int) *  length);
    srand(time(NULL)); /* create a random value */
    int i;
    for(i = 0; i < length; i++)    
        list[i] = rand()%50;/* get a <50 de  random value */
    return list;
}

int main()
{   
    int *list = CreateList(LEN);
//  int list[10] = {2, 12, 39, 32, 25, 27, 36, 36, 35, 40};
    BTNode *root = createBTree(list, LEN);   

    printf("\n prelOrder results: \n  ");
    preOrder(root);

    printf("\n inlOrder results: \n  ");
    inOrder(root);

    printf("\n postOrder results: \n  ");
    postOrder(root);

    printf("\n levelOrder results: \n  ");
    levelOrder(root);

    return 0;
}

