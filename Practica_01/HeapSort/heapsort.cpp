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
void heapify(vector<int> &a, int n, int i)
{
    int largest = i;
    int l = 2*i + 1;
    int r = 2*i + 2;
    if (l < n && a[l] > a[largest]) largest = l;
    if (r < n && a[r] > a[largest]) largest = r;
    if (largest != i)
    {
        swap(a[i], a[largest]);
        heapify(a, n, largest);
    }
}

void heapSort(vector<int> &a)
{
    int n = a.size();
    for (int i = n / 2 - 1; i >= 0; i--) heapify(a, n, i);
    for (int i=n-1; i>=0; i--)
    {
        swap(a[0], a[i]);
        heapify(a, i, 0);
    }
}
*/
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

void heapify(int a[], int n, int i)
{
    int largest = i;
    int l = 2*i + 1;
    int r = 2*i + 2;
    if (l < n && a[l] > a[largest]) largest = l;
    if (r < n && a[r] > a[largest]) largest = r;
    if (largest != i)
    {
        swap(a[i], a[largest]);
        heapify(a, n, largest);
    }
}

void heapSort(int a[],int b)
{
    int n = b;
    for (int i = n / 2 - 1; i >= 0; i--) heapify(a, n, i);
    for (int i=n-1; i>=0; i--)
    {
        swap(a[0], a[i]);
        heapify(a, i, 0);
    }
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
	  heapSort(valores,i);
    t1 = clock();
    float tiempo = ((t1-t0)/CLOCKS_PER_SEC);
    set_data(i,tiempo);
  //  valores.clear();
    val *= 2;
  }
  //valores.clear();
  agregar_valor(valores,100000);
  t0 = clock();
  heapSort(valores,100000);
  t1 = clock();
  float tiempo = ((t1-t0)/CLOCKS_PER_SEC);
  set_data(100000,tiempo);

}
