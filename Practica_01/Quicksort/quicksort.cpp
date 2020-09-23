#include <iostream>
#include <vector>
#include <ctime>
#include <fstream>
#include <iomanip>
using namespace std;


void swap(int &a,int &b)
{
    int temp = b;
    b = a;
    a = temp;
}
/*
int partition (vector<int> &a, int low, int high)
{
    int pivot = a[high];
    int i = (low - 1);

    for (int j = low; j <= high - 1; j++)
    {
        if (a[j] < pivot)
        {
            i++;
            swap(a[i], a[j]);
        }
    }
    swap(a[i + 1], a[high]);
    return (i + 1);
}


void quickSort(vector<int> &a, int low, int high)
{
    if (low < high)
    {

        int pi = partition(a, low, high);

        quickSort(a, low, pi - 1);
        quickSort(a, pi + 1, high);
    }
}

*/
int partition (int a[], int low, int high)
{
    int pivot = a[high];
    int i = (low - 1);
    for (int j = low; j <= high - 1; j++)
    {
        if (a[j] < pivot)
        {
            i++;
            swap(a[i], a[j]);
        }
    }
    swap(a[i + 1], a[high]);
    return (i + 1);
}

void quickSort(int a[], int low, int high)
{
    if (low < high)
    {
        int pi = partition(a, low, high);
        quickSort(a, low, pi - 1);
        quickSort(a, pi + 1, high);
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
    quickSort(valores,0,i-1);
    t1 = clock();
    float tiempo = ((t1-t0)/CLOCKS_PER_SEC);
    set_data(i,tiempo);
    //valores.clear();
    val *= 2;
  }
  //valores.clear();
  agregar_valor(valores,100000);
  t0 = clock();
  quickSort(valores,0,100000-1);
  t1 = clock();
  float tiempo = ((t1-t0)/CLOCKS_PER_SEC);
  set_data(100000,tiempo);
}
