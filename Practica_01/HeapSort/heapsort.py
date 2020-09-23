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


def heapify(arr, n, i):
    largest = i
    l = 2 * i + 1
    r = 2 * i + 2
    if l < n and a[i] < a[l]:
        largest = l

    if r < n and a[largest] < a[r]:
        largest = r

    if largest != i:
        a[i],a[largest] = a[largest],a[i]
        heapify(a, n, largest)

def heapSort(a):
    n = len(a)

    for i in range(n, -1, -1):
        heapify(a, n, i)

    for i in range(n-1, 0, -1):
        a[i], a[0] = a[0], a[i]
        heapify(a, i, 0)

def set_data(tamanho,tiempo):
  helper = open("valores_python.txt","a");
  helper.write(str(tamanho) + " , "+ str(tiempo) + "\n")
  helper.close();

a = []
intervalo = 1000
for k in range(1000,10000,intervalo):
    lectura(a,k)
    start_time = time()
    heapSort(a)
    elapsed_time = time() - start_time
    set_data(len(a),round(float(elapsed_time),4))
    del a[:]
    intervalo *= 2

intervalo = 10000
for k in range(10000,100001,intervalo):
    lectura(a,k)
    start_time = time()
    heapSort(a)
    elapsed_time = time() - start_time
    set_data(len(a),round(float(elapsed_time),4))
    del a[:]
