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


def bubbleSort(a):
    n = len(a)
    for i in range(n):
        swapped = False
        for j in range(0, n-i-1):
            if a[j] > a[j+1] :
                temp = a[j]
                a[j] = a[j+1]
                a[j+1] = temp
                swapped = True
        if swapped == False:
            break

def set_data(tamanho,tiempo):

  helper = open("valores_python.txt","a");
  helper.write(str(tamanho) + " , "+ str(tiempo) + "\n")
  helper.close();


a = []
intervalo = 2000
for k in range(2000,100001,intervalo):
    lectura(a,k)
    start_time = time()
    bubbleSort(a)
    elapsed_time = time() - start_time
    set_data(len(a),round(float(elapsed_time),4))
    #print("Elapsed time: %0.10f seconds." % elapsed_time)
    del a[:]
    intervalo *= 2
