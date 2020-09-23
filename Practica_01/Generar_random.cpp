#include <bits/stdc++.h>
using namespace std;
/*
void check(int a[],int b)
{
  for (size_t i = 0; i < b; i++)
  {
    a[i] +=5;
  }
}
*/
int main()
{

  srand(time(0));
  ofstream a;
  a.open("valores_10_1.txt");
  int cantidad = pow(10,1);
  int aux;
  for(int i = 0; i< cantidad;i++)
  {
      aux = rand()%10000+1;
      a << aux << endl;
  }
  a.close();

  /*
  int a[] = {1,2,3,4};
  int b = 4;
  check(a,b);
  for (size_t i = 0; i < b; i++) {
    cout << a[i]<<endl;
  }*/
}
