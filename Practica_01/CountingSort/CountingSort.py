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



def countSort(a):
    size = len(a)
    output = (size+1) *[0]
    maximo1 = max(a)
    count = (maximo1+1)*[0];

    for i in range(0,maximo1+1):
        count[i] = 0

    for i in range(0,size):
        count[a[i]]= count[a[i]] + 1

    for i in range(1,maximo1+1):
        count[i] += count[i-1]

    for i in range(size-1,-1,-1):
        output[count[a[i]]] = a[i]
        count[a[i]] -= 1

    for i in range(0,size):
        a[i] = output[i];


def set_data(tamanho,tiempo):
  helper = open("valores_python.txt","a");
  helper.write(str(tamanho) + " , "+ str(tiempo) + "\n")
  helper.close();



a = []
intervalo = 1000
for k in range(1000,10000,intervalo):
    lectura(a,k)
    start_time = time()
    countSort(a)
    elapsed_time = time() - start_time
    set_data(len(a),round(float(elapsed_time),4))
    del a[:]
    intervalo *= 2

intervalo = 10000
for k in range(10000,100001,intervalo):
    lectura(a,k)
    start_time = time()
    countSort(a)
    elapsed_time = time() - start_time
    set_data(len(a),round(float(elapsed_time),4))
    del a[:]
