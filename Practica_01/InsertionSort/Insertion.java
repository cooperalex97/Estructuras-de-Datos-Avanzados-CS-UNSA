import java.io.*;
import java.io.File;
import java.util.Scanner;

class InsertionSort {

    void sort(int a[],int b)
    {
        int n = b;
        for (int i = 1; i < n; ++i)
        {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key)
            {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
    }

    public static void main(String args[])
    {
      int[] numeros = new int[100000];
      InsertionSort ob = new InsertionSort();
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
