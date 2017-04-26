package com.hrc.openglestest;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Administrator on 2017/4/26.
 */

public class CubeSurfaceView implements GLSurfaceView.Renderer {
    private Cube cube;
    private int angle=0;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        cube=new Cube(2.0f);
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
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT|GL10.GL_DEPTH_BUFFER_BIT);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glLoadIdentity();
        //视图变换
        GLU.gluLookAt(gl,1,0,2,0.5f,-1,0,1.5f,2.5f,1);
        //向Z轴负方向移动5个位置
        gl.glTranslatef(0.0f,0.0f,-5.0f);
//        //绕着X轴旋转
//        gl.glRotatef(angle++,1,0,0);
//        //绕着Y轴旋转
//        gl.glRotatef(angle++,0,1,0);
//        //绕着Z轴旋转
//        gl.glRotatef(angle++,0,0,1);
        //绘制立方体
        cube.drawSelf(gl);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
