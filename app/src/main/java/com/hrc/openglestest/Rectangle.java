package com.hrc.openglestest;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Rectangle {
    int one=0x10000;
    private IntBuffer triangleBuffer;
    //定义的三角形的三个定点坐标
    private int[] triangleVertices=new int[]
            {0,one,0,
             -one,0,0,
             one,0,0};

//    //使用float类型定义顶点坐标值
//    private FloatBuffer rectangleBuffer;
//    //定义矩形4个顶点的坐标
//    private float[] rectangleVertices=new float[]
//            {-1.5f,1.5f,0,      //左上角的顶点坐标
//             1.5f,1.5f,0,       //右上角的顶点坐标
//             1.5f,-1.5f,0,      //右下角的顶点坐标
//             -1.5f,-1.5f,0};    //左下角的顶点坐标
//
//    private ByteBuffer indicesBuffer;
////    //索引法绘制矩形
////    private byte[] indices=new byte[]
////            {0,1,2,
////             2,3,0};
//    private byte[] indices=new byte[]
//        {1,2,3,0,0,1,2,3};

    public Rectangle(){
        ByteBuffer byteBuffer= ByteBuffer.allocateDirect(triangleVertices.length*4);
        byteBuffer.order(ByteOrder.nativeOrder());
        triangleBuffer=byteBuffer.asIntBuffer();
        triangleBuffer.put(triangleVertices);
        triangleBuffer.position(0);
//        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(rectangleVertices.length*4);
//        byteBuffer.order(ByteOrder.nativeOrder());
//        rectangleBuffer=byteBuffer.asFloatBuffer();
//        rectangleBuffer.put(rectangleVertices);
//        rectangleBuffer.position(0);
//
//        ByteBuffer byteBuffer1= ByteBuffer.allocateDirect(indices.length*4);
//        byteBuffer1.order(ByteOrder.nativeOrder());
//        indicesBuffer=byteBuffer1;
//        indicesBuffer.put(indices);
//        indicesBuffer.position(0);
    }

    public void drawSelf(GL10 gl){
        gl.glVertexPointer(3,GL10.GL_FIXED,0,triangleBuffer);
        //绘制上三角形
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP,0,3);
        //旋转180度
        gl.glRotatef(180.f,0.0f,0.0f,1.0f);
        //绘制下三角形
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP,0,3);

        gl.glVertexPointer(3,GL10.GL_FLOAT,0,triangleBuffer);
        //绘制矩形
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,0,4);

//        gl.glVertexPointer(3,GL10.GL_FLOAT,0,rectangleBuffer);
//        gl.glDrawElements(GL10.GL_LINES,8,GL10.GL_UNSIGNED_BYTE,indicesBuffer);
    }
}
