import numpy as np
import cv2
from matplotlib import pyplot as plt

#t,a = np.loadtxt('HeapSort/valores_C++.txt',delimiter = ',',unpack = True)
t,a = np.loadtxt('HeapSort/valores_C++_2.txt',delimiter = ',',unpack = True)
x,y = np.loadtxt('HeapSort/valores_python.txt',delimiter = ',',unpack = True)
m,n = np.loadtxt('HeapSort/valores_Java.txt',delimiter = ',',unpack = True)
plt.plot(t,a, color = "blue",label = "C++")
plt.plot(x,y, color = "red",label = "Python")
plt.plot(m,n, color = "green",label = "Java")
plt.title('HeapSort')
plt.xlabel('# elementos')
plt.ylabel('tiempo-segundos')
plt.legend()
plt.show();
