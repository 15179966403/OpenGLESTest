package com.hrc.openglestest;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Administrator on 2017/4/25.
 */

public class TriangleSurface implements GLSurfaceView.Renderer {
    //定义绘制三角形的Triangle对象
    private Triangle triangle;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        //创建一个Triangle对象实例
        triangle=new Triangle();
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
        //清除屏幕
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT|GL10.GL_DEPTH_BUFFER_BIT);
        //允许使用顶点方式绘制图形
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glLoadIdentity();
        //将当前位置向X轴正方向移动1个单位，向Z轴负方向移动2个单位
        gl.glTranslatef(1.0f,0.0f,-2.0f);
        //绘制第一个三角形（右侧）
        triangle.drawSelf(gl);
        //将当前矩阵设为单位矩阵
        gl.glLoadIdentity();
        //将当前位置移动
        gl.glTranslatef(-3.0f,2.0f,-5.0f);
        //绘制第二个三角形（左侧）
        triangle.drawSelf(gl);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

    }
}
