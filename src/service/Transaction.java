package service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**ע��:
 * JDK1.5�Ƴ���һ���µĶ�������,��������Ժ�Ҳ�������ֽ����ļ�
 * ע���Ӧ�ó���:
 * ��Ԫ����(�������ݵ�����)�ķ�ʽ������,����,�����ȶ���
 * ע��Ķ���:
 * 1)ʹ��@interface��������
 * 2)ʹ��@Target˵�����ע����Ӧ������ЩԪ����
 * 3)ʹ��@Retention˵�����ע���ں�ʱ��Ч
 * 
 * �����Լ�����ע��һ����������ע��������ʱ��Ч,
 * ����һ����Ϸ���ʹ��ע��.
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Transaction {//��������Ժ�Transaction.class
    
}







