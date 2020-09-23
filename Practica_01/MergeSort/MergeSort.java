import java.io.*;
import java.io.File;
import java.util.Scanner;

class MergeSort
{
    void merge(int a[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i) L[i] = a[l + i];
        for (int j=0; j<n2; ++j) R[j] = a[m + 1+ j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                a[k] = L[i];
                i++;
            }
            else
            {
                a[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            a[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            a[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int a[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
            sort(a, l, m);
            sort(a , m+1, r);
            merge(a, l, m, r);
        }
    }

    public static void main(String args[])
    {

        int[] numeros = new int[100001];
        MergeSort ob = new MergeSort();
        //ArrayList<Integer> a = new ArrayList<Integer>();
        int valor =0;
        int val = 10;
        for (int j = 1000; j < 100000; j+=val)
        {
          File fichero = new File("../valores_10_5.txt");
          Scanner s = null;
          valor = 0;
          try
          {
              s = new Scanner(fichero);

              while (s.hasNextLine())
              {
                  if(valor == j) break;
                  String linea = s.nextLine();
                  numeros[valor++] = Integer.parseInt(linea);
              }

          }
          catch(Exception ex)
          {
              System.out.println("Mensaje: " + ex.getMessage());
          }
          finally
          {
              try
              {
                  if (s != null) s.close();
              }
              catch (Exception ex2)
              {
                  System.out.println("Mensaje 2: " + ex2.getMessage());
              }
          }
          double TInicio, TFin, tiempo;
          TInicio = System.currentTimeMillis();
          ob.sort(numeros, 0, valor-1);
          TFin = System.currentTimeMillis();
          tiempo = (TFin - TInicio)/1000;

          File archivo = new File("valores_Java.txt");
          BufferedWriter bw = null;
          FileWriter fw = null;
          try
          {
            fw = new FileWriter(archivo.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(Integer.toString(j) + "," + Double.toString(tiempo)+"\n");
            bw.close();
          }
          catch(IOException e)
          {
            System.out.println("Error E/S: "+e);
          }
          finally
          {
            try
            {
                if (bw != null) bw.close();
                if (fw != null) fw.close();
            }
            catch (IOException ex)
            {
                System.out.println("Error E/S: "+ex);
            }

          }
          val+=1000;
        }

        // Empieza parte Final
        File fichero = new File("../valores_10_5.txt");
        Scanner s = null;
        valor = 0;
        try
        {
            s = new Scanner(fichero);

            while (s.hasNextLine())
            {
                String linea = s.nextLine();
                numeros[valor++] = Integer.parseInt(linea);
            }

        }
        catch(Exception ex)
        {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        finally
        {
            try
            {
                if (s != null) s.close();
            }
            catch (Exception ex2)
            {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
        double TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis();
        ob.sort(numeros, 0, valor-1);
        TFin = System.currentTimeMillis();
        tiempo = (TFin - TInicio)/1000;

        File archivo = new File("valores_Java.txt");
        BufferedWriter bw = null;
        FileWriter fw = null;
        try
        {
          fw = new FileWriter(archivo.getAbsoluteFile(), true);
          bw = new BufferedWriter(fw);
          bw.write(Integer.toString(valor) + "," + Double.toString(tiempo)+"\n");
          bw.close();
        }
        catch(IOException e)
        {
          System.out.println("Error E/S: "+e);
        }
        finally
        {
          try
          {
              if (bw != null) bw.close();
              if (fw != null) fw.close();
          }
          catch (IOException ex)
          {
              System.out.println("Error E/S: "+ex);
          }

        }



    }
}
