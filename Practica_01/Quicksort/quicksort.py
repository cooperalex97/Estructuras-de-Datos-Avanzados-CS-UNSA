from time import time

def lectura(a,k):
    archivo = open("../valores_10_5.txt","r")
    avance = 0
    for linea in archivo.readlines():
        if avance == k:
            break
        array = linea
        a.append(int(array))
        avance += 1
    archivo.close()



def partition(a,low,high):
    i = ( low-1 )
    pivot = a[high]

    for j in range(low , high):
        if a[j] < pivot:
            i = i+1
            a[i],a[j] = a[j],a[i]

    a[i+1],a[high] = a[high],a[i+1]
    return ( i+1 )


def quickSort(a,low,high):
    if low < high:
        pi = partition(a,low,high)
        quickSort(a, low, pi-1)
        quickSort(a, pi+1, high)


def set_data(tamanho,tiempo):
  helper = open("valores_python.txt","a");
  helper.write(str(tamanho) + " , "+ str(tiempo) + "\n")
  helper.close();

a = []
intervalo = 1000
for k in range(1000,10000,intervalo):
    lectura(a,k)
    start_time = time()
    quickSort(a,0,len(a)-1)
    elapsed_time = time() - start_time
    set_data(len(a),round(float(elapsed_time),4))
    del a[:]
    intervalo *= 2

intervalo = 10000
for k in range(10000,100001,intervalo):
    lectura(a,k)
    start_time = time()
    quickSort(a,0,len(a)-1)
    elapsed_time = time() - start_time
    set_data(len(a),round(float(elapsed_time),4))
    del a[:]
