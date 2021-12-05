package java3_lesson3;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MainClass {

    public static void main(String[] args) {
        //byteArrStream();
//        fileStream();
        //fileStream2();
//        fileStream3();
//        fileStream4();
          decoder();
    }

    private static void decoder() {
        String data = "SmF2YSDQvdC1INGC0L7RgNC80L7Qt9C40YIhCg==";
        try {
            String second = new String(data.getBytes(StandardCharsets.UTF_8),"unicode");
            System.out.println(second);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static void fileStream4(){
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream("data.txt"))){
            for(int i = 0; i<160;i++) {
                out.write(i);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        try(InputStream in = new BufferedInputStream(new FileInputStream("data.txt"))){
            int x;
            while((x=in.read())!=-1){
                System.out.print((char)x);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void fileStream3() {
        byte [] arr = new byte[20];
        int count;
        try (FileInputStream in = new FileInputStream("data.txt")){
            count = in.read(arr);
                for(int i = 0; i<count;i++){
                    System.out.print((char)arr[i]);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileStream2() { // запись массива целиком 1 операцией работает в 100 раз быстрее
        byte [] arr = new byte[1024*1024];
        for (int i=0; i< arr.length;i++)
            arr[i] = 66;
        long startTime = System.currentTimeMillis();
        try (FileOutputStream out = new FileOutputStream("data.txt")){
            //            out.write(arr);
            for(int i=0;i< arr.length;i++){
                out.write(arr[i]);
            }
            System.out.println("time "+(System.currentTimeMillis()-startTime));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileStream() {
        try (FileOutputStream out = new FileOutputStream("data.txt")){
            byte [] arr = "hi all users!!".getBytes();
            out.write(arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void byteArrStream(){
        byte[] arr = {65, 66, 67};
        ByteArrayInputStream in = new ByteArrayInputStream(arr);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(67);
        out.write(66);
        out.write(65);
        int x;
        while ((x = in.read()) != -1) {
            System.out.print(((char) x) + " ");
        }
        byte[] arr1 = out.toByteArray();
        System.out.println();
        for (byte u : arr1)
            System.out.print((char) u + " ");
    }
}
