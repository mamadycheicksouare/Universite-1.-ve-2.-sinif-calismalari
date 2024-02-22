// MAMADY CHEICK SOUARE 20100011002 ODEV3


// NOT: SAYILAR PROGRAM TEK BASAMAKLI SAYILAR ICIN VE HESAPLAMA SADECE SAYISAL DEGERLERE UYGULANIR!!!!
// NOT: INFIX DOSYASINDA BOSLUK OLMAYACAK!!!!!! ICINDE BIR ORNEK INFIX BULUNMAKTADIR!!!!!
// NOT: ADIMLAR VE COZUM EKRANA YAZDIRILACAK PENCEREYI BUYUTEREK DAHA NET GOREBILIRSINIZ!!!!!

//ADIMLAR (INFIX; STACK; POSTFIX)
//COZUM VE SONUC (POSTFIX; STACK)
#include <stdio.h>
#include <stdlib.h>
#include<ctype.h>
#include<math.h>

// STACK FOR USED TO CALCULATE POSTFIX VALUE*************************************************
typedef struct node2

{
  struct node2 *next;
  double  value;
} laststack;

laststack *last = NULL;
int lastcount =0;

void lastpush(double value)
{

    laststack *newnode = malloc(sizeof(laststack));
    newnode->value = value;
    newnode->next = NULL;

    if(last== NULL)
    {
        newnode->next = newnode;
        last = newnode;
    }
    else
    {
        newnode->next = last->next;
        last->next = newnode;

    }

    lastcount++;
}


void lastpop()

{if(lastcount==0)
return;

    laststack *temp = last->next;
    if(temp ==last)
    {
        free(temp);
        last=NULL;
    }
    else
    {
        last->next = temp->next;
        free(temp);
    }

    lastcount--;
}


void lastlistele()
{
    if(lastcount ==0)
        return;
    laststack *iter = last->next;
    for(int i=0; i<lastcount; i++)
    {
        printf("%lf   ",iter->value);
        iter= iter->next;
    }

}



// STACK FOR INFIX TO POSTFIX CONVERSION*********************************************************************
typedef struct node
{

    struct node *next;
    char c;
} stack;

stack *son = NULL;
int count=0;





int isoperator(char c)
{
    if(c == '-' || c == '+' || c == '*' || c == '/'  || c == '^' )
        return 1;
    else
        return 0;
}

int precedencein(char c)
{

    if(c == '-' || c == '+')
        return 1;
    else if(c == '*' || c == '/')
        return 2;
    else if(c == '^')
        return 3;
    else if(c=='(')
        return 0;


}

int precedenceout(char c)
{
    if(c == '-' || c == '+')
        return 1;
    else if(c == '*' || c == '/')
        return 2;
    else if(c == '^' || c== '(')
        return 4;

}


void push(char c)
{

    stack *newnode = malloc(sizeof(stack));
    newnode->c = c;
    newnode->next = NULL;

    if(son== NULL)
    {
        newnode->next = newnode;
        son = newnode;
    }
    else
    {
        newnode->next = son->next;
        son->next = newnode;

    }

    count++;
}


void pop()

{if(count==0)
return;

    stack *temp = son->next;
    if(temp ==son)
    {
        free(temp);
        son=NULL;
    }
    else
    {
        son->next = temp->next;
        free(temp);
    }

    count--;
}


void listele()
{
    if(count ==0)
    return;
    stack *iter = son->next;
    for(int i=0; i<count; i++)
    {
        printf("%c",iter->c);
        iter= iter->next;
    }

}


int isempty()
{
    if (count==0)
        return 1;
    else
        return 0;
}

double op(double op1, double op2, char c)
{
    if(c == '+')
    return op1 + op2;
    if(c == '-')
   return op1 - op2;
    if(c == '/')
    return op1 / op2;
    if(c == '*')
     return op1 * op2;
    if(c == '^')
    return pow(op1,op2);
}

//***********************************************MAIN FUNCTION*************************************************************************
int main()
{

    FILE *file = fopen("infix.txt","r");
    char ch;
    int i=0;

    while ((ch = fgetc(file)) != EOF)
    {
        i++;
    }

    fseek(file, 0, SEEK_SET);
    char infix[i];
    char postfix[i];
    int len_pos=0;
    int kontrol=0;

    int j=0;
    int k;
    while ((ch = fgetc(file)) != EOF)
    {
        infix[j] = ch;
        j++;
    }
printf("*****************************ADIMLAR*****************************************************\n\n");

    for(int j=0; j<i; j++)
    {
        if(isoperator(infix[j]) == 0 && infix[j] != '(' && infix[j] != ')')
        {
            postfix[len_pos] = infix[j];
            len_pos++;
        }

        else if(infix[j] == '(')
        {
            push(infix[j]);

        }

        else if(infix[j] == ')')
        {   if(isempty() == 1)
            continue;


           else {


            while(isoperator(son->next->c) == 1  && son->next->c != '(' && count>0)
            {
                postfix[len_pos] = son->next->c;
                pop();

                len_pos++;

                kontrol =1;

            }
            if(kontrol == 1)
            {
                pop();
                kontrol =0;

            }
           }

        }


        else if  (isoperator(infix[j]) == 1)

        {
            while(isempty() == 0 && precedenceout(infix[j]) <= precedencein(son->next->c))
            {
                postfix[len_pos] = son->next->c;
                len_pos++;
                pop();
            }
            push(infix[j]);

        }

        for( k=j;k<i;k++)
        {
            printf("%c",infix[k]);

        }

              printf("  .............   ");

              listele();

            printf("   ..............   ");

          for(k=0;k<len_pos;k++)
          {
              printf("%c",postfix[k]);
          }
          printf("\n");


    }




    while( count !=0 )
    {
        if(isoperator(son->next->c) == 1)
        {
            postfix[len_pos] = son->next->c;
            pop();
            len_pos++;
        }
    }
    printf("\n\n\n");

printf("****************************POSTFIX******************************************************\n\n\n");

    for( k=0; k<len_pos; k++)
    {
        printf("%c",postfix[k]);
    }
    printf("\n\n\n\n\n");

printf("*****************************COZUM VE SONUC*****************************************************\n\n\n");


 while(count != 0)
 {
     pop();
 }


double doublevalue, temp;
  for(i=0;i<len_pos;i++)
  {
      if(isdigit(postfix[i]))
        {
           doublevalue = (double)(postfix[i] - '0');
           lastpush(doublevalue);
        }
      else{
            temp = op(last->next->next->value,last->next->value,postfix[i]);
         lastpop();
         lastpop();
         lastpush(temp);
      }

      for(j=i;j<len_pos;j++)
      {
          printf("%c",postfix[j]);
      }
     printf("     ..................   \t");
      lastlistele();
      printf("\n");


  }
printf("\n");
  printf("DEGER----------> ");
   lastlistele();

    fclose(file);
    return 0;
}

