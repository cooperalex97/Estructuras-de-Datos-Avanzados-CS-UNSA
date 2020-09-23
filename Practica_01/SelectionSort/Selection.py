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


def SelectionSort(a):
    for i in range(len(a)):
        min_idx = i
        for j in range(i+1, len(a)):
            if a[min_idx] > a[j]:
                min_idx = j
        a[i],a[min_idx] = a[min_idx], a[i]

def set_data(tamanho,tiempo):
  helper = open("valores_python.txt","a");
  helper.write(str(tamanho) + " , "+ str(tiempo) + "\n")
  helper.close();

a = []
intervalo = 1000
for k in range(1000,10000,intervalo):
    lectura(a,k)
    start_time = time()
    SelectionSort(a)
    elapsed_time = time() - start_time
    set_data(len(a),round(float(elapsed_time),4))
    del a[:]
    intervalo *= 2

intervalo = 10000
for k in range(10000,100001,intervalo):
    lectura(a,k)
    start_time = time()
    SelectionSort(a)
    elapsed_time = time() - start_time
    set_data(len(a),round(float(elapsed_time),4))
    del a[:]
