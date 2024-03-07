// MAMADY CHEICK SOUARE
/*
txt File format
Number of nodes
node1, neighbor1-weight,............
.
.
.
.
.
.
.


*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>



struct node {

    int vertex;
    int weight;
    struct node *next;

};

struct node * createnode(int vertex)
{
     struct node * newnode = malloc(sizeof(struct node));
     newnode->vertex = vertex;
     newnode->weight=0;
     newnode->next= NULL;

   return newnode;
}

// Adding edge to the grapg

void addedge(struct node* adj[], int src, int dest,int weight)
{
    struct node* newnode = createnode(dest);
    newnode->next = adj[src];
    newnode->weight = weight;
    adj[src] = newnode;
}





// Depth first search

void DFS(struct node* adj[], int v, bool visited[]) {
    visited[v] = true;
    printf("%d ", v);

    // Sorting the adjacent vertices edge weights in ascending order

    struct node* temp = adj[v];
    int adjVertices[100];
    int weights[100];
    int count = 0;
    while (temp) {
        adjVertices[count] = temp->vertex;
        weights[count] = temp->weight;
        temp = temp->next;
        count++;
    }
    // Sorting

    for (int i = 0; i < count - 1; ++i) {
        for (int j = 0; j < count - i - 1; ++j) {
            if (weights[j] > weights[j + 1]) {

                int tempVertex = adjVertices[j];
                adjVertices[j] = adjVertices[j + 1];
                adjVertices[j + 1] = tempVertex;
                int tempWeight = weights[j];
                weights[j] = weights[j + 1];
                weights[j + 1] = tempWeight;
            }
        }
    }

    // Traversing recursively
    for (int i = 0; i < count; ++i) {
        int nextVertex = adjVertices[i];
        if (!visited[nextVertex]) {
            DFS(adj, nextVertex, visited);
        }
    }
}


// DFS traversal

void DFSTraversal(struct node* adj[], int numvertices, int startVertex) {
    bool visited[numvertices];
    for (int i = 0; i < numvertices; ++i)
        visited[i] = false;

    printf("DFS Traversal: ");
    DFS(adj, startVertex, visited);
    printf("\n");
}


//*****************ABOUT BFS IMPLEMENTATION***********************************


struct QueueNode {
    int vertex;
    struct QueueNode* next;
};


struct Queue {
    struct QueueNode *front, *rear;
};


//  Create a new queue node
struct QueueNode* createQueueNode(int v) {
    struct QueueNode* newNode = (struct QueueNode*)malloc(sizeof(struct QueueNode));
    newNode->vertex = v;
    newNode->next = NULL;
    return newNode;
}

// Create an empty queue
struct Queue* createQueue() {
    struct Queue* q = (struct Queue*)malloc(sizeof(struct Queue));
    q->front = q->rear = NULL;
    return q;
}

// Function to check if the queue is empty
bool isEmpty(struct Queue* q) {
    return (q->front == NULL);
}

// Enqueue a vertex to the queue
void enqueue(struct Queue* q, int v) {
    struct QueueNode* newNode = createQueueNode(v);
    if (isEmpty(q)) {
        q->front = q->rear = newNode;
    } else {
        q->rear->next = newNode;
        q->rear = newNode;
    }
}

// Dequeue a vertex from the queue
int dequeue(struct Queue* q) {
    if (isEmpty(q)) {
        printf("Queue is empty\n");
        return -1;
    }
    struct QueueNode* temp = q->front;
    int v = temp->vertex;
    q->front = q->front->next;
    free(temp);
    return v;
}

// Breadth-First Search (BFS)
void BFS(struct node* adj[], int numVertices, int startVertex) {
    bool visited[numVertices];
    for (int i = 0; i < numVertices; ++i)
        visited[i] = false;

    struct Queue* q = createQueue();
    visited[startVertex] = true;
    enqueue(q, startVertex);

    printf("BFS Traversal: ");
    while (!isEmpty(q)) {
        int v = dequeue(q);
        printf("%d ", v);

        // Sorting the adjacent vertices weights in ascending order
        struct node* temp = adj[v];
        int adjVertices[100];
        int weights[100];
        int count = 0;
        while (temp) {
            adjVertices[count] = temp->vertex;
            weights[count] = temp->weight;
            temp = temp->next;
            count++;
        }
        // Bubble sort

        for (int i = 0; i < count - 1; ++i) {
            for (int j = 0; j < count - i - 1; ++j) {
                if (weights[j] > weights[j + 1]) {
                    // Swap vertices
                    int tempVertex = adjVertices[j];
                    adjVertices[j] = adjVertices[j + 1];
                    adjVertices[j + 1] = tempVertex;
                    // Swap weights
                    int tempWeight = weights[j];
                    weights[j] = weights[j + 1];
                    weights[j + 1] = tempWeight;
                }
            }
        }

        // Enqueue the sorted adjacent vertices
        for (int i = 0; i < count; ++i) {
            int adjVertex = adjVertices[i];
            if (!visited[adjVertex]) {
                visited[adjVertex] = true;
                enqueue(q, adjVertex);
            }
        }
    }
    printf("\n");
}


// Function to print the adjacency list of the graph
void printgraph(struct node* adj[], int n) {
    for (int i = 0; i < n; ++i) {
        struct node* temp = adj[i];
        printf("%d", i);
        while (temp) {
            printf(" -> %d(weight: %d)", temp->vertex, temp->weight);
            temp = temp->next;
        }
        printf(" -> NULL\n");
        printf("\n");
    }

    printf("\n");
}


int main() {

int numvertices;
char line[100];
int vertex,neighbor,weight;

FILE *data;

data = fopen("data.txt","r");
if(data ==NULL)
{
    printf("Error while opening the file\n");
    return -1;
}

fgets(line,sizeof(line),data);
numvertices = atoi(line);

struct node* adj[numvertices];
    for (int i = 0; i < numvertices; ++i)
        adj[i] = NULL;



  while (fgets(line, sizeof(line), data)) {
        sscanf(line, "%d", &vertex);
        char *token = strtok(line, ",");
        token = strtok(NULL, ",");
        while (token != NULL) {
            sscanf(token, "%d-%d", &neighbor, &weight);
            addedge(adj, vertex, neighbor, weight);
            token = strtok(NULL, ",");
        }
    }

fclose(data);

printgraph(adj,numvertices);






     int choice, startvertice;
    while(1){
        printf("1- DFS\n2- BFS\n0- Exit\n");


    scanf("%d",&choice);

    while(choice > 3 || choice < 0)
    {   printf("invalid choice choose again\n");
        scanf("%d",&choice);
    }


    if (choice == 0)
        exit(0);


    else if(choice == 1)
    {
        printf("Choose starting vertex--->");
        scanf("%d",&startvertice);
        while(startvertice >= numvertices)
        {    printf("This vertex does not exists choose another one----->");
             scanf("%d",&startvertice);
        }
        printf("\n");

        DFSTraversal(adj,numvertices,startvertice);
    }



    else if(choice == 2)
    {
         printf("Choose starting vertex--->");
        scanf("%d",&startvertice);
        while(startvertice >= numvertices)
        {    printf("This vertex does not exists choose another one------>");
             scanf("%d",&startvertice);
        }

        printf("\n");
        BFS(adj, numvertices, startvertice);
    }

    }

    return 0;
}

