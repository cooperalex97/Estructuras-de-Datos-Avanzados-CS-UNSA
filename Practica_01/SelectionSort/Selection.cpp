#include <iostream>
#include <vector>
#include <ctime>
#include <fstream>
#include <iomanip>

using namespace std;
/*
void selectionSort(vector<int> &a)
{
    int min_idx;
    int n =  a.size();
    for (int i = 0; i < n-1; i++)
    {
        min_idx = i;
        for (int j = i+1; j < n; j++)
        {
            if (a[j] < a[min_idx]) min_idx = j;
        }
        int temp = a[min_idx];
        a[min_idx] = a[i];
        a[i] = temp;
    }
}
*/

void selectionSort(int a[],int b)
{
    int min_idx;
    int n =  b;
    for (int i = 0; i < n-1; i++)
    {
        min_idx = i;
        for (int j = i+1; j < n; j++)
        {
            if (a[j] < a[min_idx]) min_idx = j;
        }
        int temp = a[min_idx];
        a[min_idx] = a[i];
        a[i] = temp;
    }
}
void agregar_valor(int a[],int carga)
{
    fstream texto("../valores_10_5.txt");
    int aux;
    for (int i = 0; i < carga; i++)
    {
        texto >> aux;
        a[i] = aux;
    }
    texto.close();
}

/*
void agregar_valor(vector<int> &a,int carga)
{
    fstream texto("../valores_10_5.txt");
    int aux;
    for (int i = 0; i < carga; i++)
    {
        texto >> aux;
        a.push_back(aux);
    }
    texto.close();
}
*/
void set_data(int tamanho,float tiempo)
{
  fstream helper;
  helper.open("valores_C++_2.txt");
  helper.seekg (0,helper.end);
  helper << tamanho << " , ";
  helper<<fixed<<setprecision(5)<<tiempo<<endl;
  helper.close();
}



int main()
{

  //vector<int> valores;
  int valores[100000];
  int val = 10;
  float t0,t1;
  for(int i= 10; i < 100000;i += val)
  {
    agregar_valor(valores,i);
    t0 = clock();
    selectionSort(valores,i);
    t1 = clock();
    float tiempo = ((t1-t0)/CLOCKS_PER_SEC);
    set_data(i,tiempo);
    //valores.clear();
    val *= 2;
  }
  //valores.clear();
  agregar_valor(valores,100000);
  t0 = clock();
  selectionSort(valores,100000);
  t1 = clock();
  float tiempo = ((t1-t0)/CLOCKS_PER_SEC);
  set_data(100000,tiempo);


}
