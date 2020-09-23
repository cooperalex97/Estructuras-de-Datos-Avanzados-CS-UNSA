#include <iostream>
#include <vector>
#include <ctime>
#include <fstream>
#include <iomanip>
using namespace std;

void swap(int &a, int &b)
{
    int temp = a;
    a = b;
    b = temp;
}

void bubbleSort(int a[],int b)
{
	  int tamanho = b;
  	bool swapped;
    for (int i = 0; i < tamanho-1; i++)
    {
    	swapped = false;
    	for (int j = 0; j < tamanho-i-1; j++)
    	{
    		if (a[j] > a[j+1])
    		{
    			swap(a[j], a[j+1]);
    			swapped = true;
    		}
    	}
    	if(!swapped) break;
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
void bubbleSort(vector<int>&a)
{
	  int tamanho = a.size();
  	bool swapped;
    for (int i = 0; i < tamanho-1; i++)
    {
    	swapped = false;
    	for (int j = 0; j < tamanho-i-1; j++)
    	{
    		if (a[j] > a[j+1])
    		{
    			swap(a[j], a[j+1]);
    			swapped = true;
    		}
    	}
    	if(!swapped) break;
    }
}


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
    bubbleSort(valores,i);
    t1 = clock();
    float tiempo = ((t1-t0)/CLOCKS_PER_SEC);
    set_data(i,tiempo);
    //valores.clear();
    val *= 2;
  }
  //valores.clear();
  agregar_valor(valores,100000);
  t0 = clock();
  bubbleSort(valores,100000);
  t1 = clock();
  float tiempo = ((t1-t0)/CLOCKS_PER_SEC);
  set_data(100000,tiempo);


}
