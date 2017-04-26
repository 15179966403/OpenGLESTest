package com.hrc.openglestest;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Triangle {
    int one=0x10000;
    private IntBuffer triangleBuffer;
    //定义三角形的3个顶点坐标
    private int[] triangleVertices=new int[]
            {0,one,0,
            -one,-one,0,
            one,-one,0};
    public Triangle(){
        //下面的代码将int类型的坐标值放到IntBuffer对象中
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(triangleVertices.length*4);
        byteBuffer.order(ByteOrder.nativeOrder());
        triangleBuffer=byteBuffer.asIntBuffer();
        triangleBuffer.put(triangleVertices);
        triangleBuffer.position(0);
    }

    public void drawSelf(GL10 gl){
        //将3个顶点坐标装载到内存中
        gl.glVertexPointer(3,GL10.GL_FIXED,0,triangleBuffer);
        //绘制三角形
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP,0,3);
    }
}
