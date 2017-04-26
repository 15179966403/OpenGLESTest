package com.hrc.openglestest;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Cube {
    private float v;
    //保存144个坐标值
    private float[] cubeVertices;
    private FloatBuffer cubeVerticesBuffer;

    public Cube(Float size){
        //size为立方体的边长
        v=size/2;
        //初始化坐标值
        cubeVertices=new float[]{
                //z轴正方向平面
                -v,v,v,
                v,v,v,
                v,v,v,
                v,-v,v,
                v,-v,v,
                -v,-v,v,
                -v,-v,v,
                -v,v,v,
                //z轴负方向平面
                -v,v,-v,
                v,v,-v,
                v,v,-v,
                v,-v,-v,
                v,-v,-v,
                -v,-v,-v,
                -v,-v,-v,
                -v,v,-v,
                //左侧平面
                -v,v,-v,
                -v,v,v,
                -v,v,v,
                -v,-v,v,
                -v,-v,v,
                -v,-v,-v,
                -v,-v,-v,
                -v,v,-v,
                //右侧平面
                v,v,-v,
                v,v,v,
                v,v,v,
                v,-v,v,
                v,-v,v,
                v,-v,-v,
                v,-v,-v,
                v,v,-v,
                //顶面
                -v,v,v,
                v,v,v,
                v,v,v,
                v,v,-v,
                v,v,-v,
                -v,v,-v,
                -v,v,-v,
                -v,v,v,
                //底面
                -v,-v,v,
                v,-v,v,
                v,-v,v,
                v,-v,-v,
                v,-v,-v,
                -v,-v,-v,
                -v,-v,-v,
                -v,-v,v,
        };
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(cubeVertices.length*4);
        byteBuffer.order(ByteOrder.nativeOrder());
        cubeVerticesBuffer=byteBuffer.asFloatBuffer();
        cubeVerticesBuffer.put(cubeVertices);
        cubeVerticesBuffer.position(0);
    }

    public void drawSelf(GL10 gl){
        //装载顶点坐标值
        gl.glVertexPointer(3,GL10.GL_FLOAT,0,cubeVerticesBuffer);
        //绘制6个平面
        for (int i=0;i<24;i++){
            //绘制组成平面的每一条直线
            gl.glDrawArrays(GL10.GL_LINES,i*2,2);
        }
    }
}
