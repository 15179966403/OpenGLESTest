package com.hrc.openglestest;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class RectangleSurfaceView implements GLSurfaceView.Renderer {
    private Rectangle rectangle;
    private int angle1=0;   //控制中心矩形的逆时针旋转的角度变量
    private int angle2=0;   //控制4个小矩形顺时针旋转的角度变量

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        rectangle=new Rectangle();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        float ratio=(float)width/height;
        //设置视口大小
        gl.glViewport(0,0,width,height);
        //设置当前矩阵模式为投影矩阵
        gl.glMatrixMode(GL10.GL_PROJECTION);
        //设置当前矩阵为单位矩阵
        gl.glLoadIdentity();
        //设置透视投影的刻度范围
        gl.glFrustumf(-ratio*2,ratio*2,-2,2,1,10);
        //设置当前矩阵模式为模型视图矩阵
        gl.glMatrixMode(GL10.GL_MODELVIEW);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
//        gl.glClear(GL10.GL_COLOR_BUFFER_BIT|GL10.GL_DEPTH_BUFFER_BIT);
//        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
//        gl.glLoadIdentity();
//        gl.glTranslatef(0.0f,0.0f,-2.0f);
//        rectangle.drawSelf(gl);
//
//        gl.glTranslatef(0.0f,0.0f,-2.0f);
//        //绘制中心的矩形
//        rectangle.drawSelf(gl);
//
//        gl.glLoadIdentity();
//        gl.glTranslatef(-3.0f,0.0f,-4.0f);
//        gl.glRotatef(45,0.0f,0.0f,1.0f);
//        //绘制左侧矩形
//        rectangle.drawSelf(gl);
//
//        gl.glLoadIdentity();
//        gl.glTranslatef(3.0f,0.0f,-4.0f);
//        gl.glRotatef(45,0.0f,0.0f,1.0f);
//        //绘制右侧矩形
//        rectangle.drawSelf(gl);
//
//        gl.glLoadIdentity();
//        gl.glTranslatef(0.0f,3.0f,-4.0f);
//        gl.glRotatef(45,0.0f,0.0f,1.0f);
//        //绘制上方的矩形
//        rectangle.drawSelf(gl);
//
//        gl.glLoadIdentity();
//        gl.glTranslatef(0.0f,-3.0f,-4.0f);
//        gl.glRotatef(45,0.0f,0.0f,1.0f);
//        //绘制下方矩形
//        rectangle.drawSelf(gl);

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT|GL10.GL_DEPTH_BUFFER_BIT);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glLoadIdentity();


        gl.glTranslatef(0.0f,0.0f,-2.0f);
        gl.glRotatef(angle1++,0,0,1);
        rectangle.drawSelf(gl);

//        gl.glTranslatef(0.0f,0.0f,-2.0f);
//        //绘制中心的矩形
//        //使中心的矩形逆时针旋转
//        gl.glRotatef(angle1++,0,0,1);
//        rectangle.drawSelf(gl);

        gl.glLoadIdentity();
        angle2-=2;  //改变顺时针旋转的角度，步长为2
        //顺时针旋转
        gl.glRotatef(angle2,0,0,1);
        gl.glTranslatef(-3.0f,0.0f,-4.0f);
        gl.glRotatef(45,0.0f,0.0f,1.0f);
        //绘制左侧矩形
        rectangle.drawSelf(gl);

        gl.glLoadIdentity();
        gl.glRotatef(angle2,0,0,1);
        gl.glTranslatef(3.0f,0.0f,-4.0f);
        gl.glRotatef(45,0.0f,0.0f,1.0f);
        //绘制右侧矩形
        rectangle.drawSelf(gl);

        gl.glLoadIdentity();
        gl.glRotatef(angle2,0,0,1);
        gl.glTranslatef(0.0f,3.0f,-4.0f);
        gl.glRotatef(45,0.0f,0.0f,1.0f);
        //绘制上方的矩形
        rectangle.drawSelf(gl);

        gl.glLoadIdentity();
        gl.glRotatef(angle2,0,0,1);
        gl.glTranslatef(0.0f,-3.0f,-4.0f);
        gl.glRotatef(45,0.0f,0.0f,1.0f);
        //绘制下方矩形
        rectangle.drawSelf(gl);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
