import java.io.*;
import java.io.File;
import java.util.Scanner;

class Quicksort
{
    int partition(int a[], int low, int high)
    {
        int pivot = a[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (a[j] < pivot)
            {
                i++;

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i+1];
        a[i+1] = a[high];
        a[high] = temp;

        return i+1;
    }

    void sort(int a[], int low, int high)
    {
        if (low < high)
        {

            int pi = partition(a, low, high);
            sort(a, low, pi-1);
            sort(a, pi+1, high);
        }
    }

    public static void main(String args[])
    {
      int[] numeros = new int[100001];
      Quicksort ob = new Quicksort();
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
        ob.sort(numeros, 0, valor);
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
      ob.sort(numeros, 0, valor);
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
