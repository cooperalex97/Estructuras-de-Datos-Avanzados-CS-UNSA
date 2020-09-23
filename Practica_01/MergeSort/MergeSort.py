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


def merge(L, R):
    i = 0
    j = 0
    ret = []
    while i < len(L) and j < len(R):
        if(L[i]<R[j]):
          ret.append(L[i])
          i=i+1
        else:
          ret.append(R[j])
          j=j+1

    ret += L[i:]
    ret += R[j:]
    return ret


def mergeSort(A):

    n = len(A)
    if n <= 1:
        return A
    L = mergeSort(A[:n // 2])
    R = mergeSort(A[n // 2:n])
    return merge(L,R)

def set_data(tamanho,tiempo):
  helper = open("valores_python.txt","a");
  helper.write(str(tamanho) + " , "+ str(tiempo) + "\n")
  helper.close();

a = []
intervalo = 1000
for k in range(1000,10000,intervalo):
    lectura(a,k)
    start_time = time()
    mergeSort(a)
    elapsed_time = time() - start_time
    set_data(len(a),round(float(elapsed_time),4))
    del a[:]
    intervalo *= 2

intervalo = 10000
for k in range(10000,100001,intervalo):
    lectura(a,k)
    start_time = time()
    mergeSort(a)
    elapsed_time = time() - start_time
    set_data(len(a),round(float(elapsed_time),4))
    del a[:]
