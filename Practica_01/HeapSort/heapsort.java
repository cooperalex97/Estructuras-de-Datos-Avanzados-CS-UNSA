import java.io.*;
import java.io.File;
import java.util.Scanner;

class HeapSort
{
   public void sort(int a[],int b)
    {
        int n = b;

        for (int i = n / 2 - 1; i >= 0; i--) heapify(a, n, i);

        for (int i=n-1; i>=0; i--)
        {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a, i, 0);
        }
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
            int swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;
            heapify(a, n, largest);
        }
    }


    public static void main(String args[])
    {
      int[] numeros = new int[100001];
      HeapSort ob = new HeapSort();

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
        ob.sort(numeros,valor);
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
      ob.sort(numeros,valor);
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
