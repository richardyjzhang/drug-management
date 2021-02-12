import React from 'react';
import { Button, Form, Input } from 'antd';
import { UserOutlined, LockOutlined } from '@ant-design/icons';
import styles from './index.css';

const LoginPage = () => {
    const onFinish = (values: any) => {
        console.log('Received values of form: ', values);
    };

    return (
        <Form
            className={styles.loginWrapper}
            name="normal_login"
            initialValues={{ remember: true }}
            onFinish={onFinish}
        >
            <Form.Item
                name="username"
                rules={[{ required: true, message: '请输入用户名!' }]}
            >
                <Input prefix={<UserOutlined />} placeholder="用户名" />
            </Form.Item>
            <Form.Item
                name="password"
                rules={[{ required: true, message: '请输入密码!' }]}
            >
                <Input
                    prefix={<LockOutlined />}
                    type="password"
                    placeholder="密码"
                />
            </Form.Item>

            <Form.Item>
                <Button type="primary" htmlType="submit" className={styles.loginButton}>
                    登录
                </Button>
            </Form.Item>
        </Form>
    );
}

export default LoginPage;