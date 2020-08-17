package com.example.demo.test;


public class MyBitmap {
    private long[] words;
    private int size;

    public MyBitmap (int size) {
        this.size = size;
        this.words = new long[(getWordIndex(size - 1) + 1)];
    }

    private int getWordIndex (int bitIndex) {
        return bitIndex >> 6;
    }

    public void setBit (int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("超出Bitmap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] = (1L << bitIndex);
    }

    public boolean getBit (int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("超出Bitmap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        return ((words[wordIndex] & (1L << bitIndex)) != 0);
    }

    public static void main(String[] args) {
        MyBitmap bitmap = new MyBitmap(128);
        bitmap.setBit(126);
        System.out.println(bitmap.getBit(126));
        System.out.println((1L << 12));
        System.out.println((1L << 126));
    }
}
