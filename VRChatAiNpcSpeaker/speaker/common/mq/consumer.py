import pika

EXCHANGE_NAME = "cafe.topic";
QUEUE_NAME = "coffee.queue";
ROUTING_KEY = "order.coffee.#";

def callback(ch, method, properties, body):
    print(" [x] Received %r" % (body))

connection = pika.BlockingConnection(pika.ConnectionParameters(host='http://192.168.255.128:15672'));
channel = connection.channel();
channel.queue_declare(queue=QUEUE_NAME);
channel.basic_consume(callback, queue=QUEUE_NAME, no_ack=True);
print(' [*] Waiting for messages. To exit press CTRL+C');
channel.start_consuming();

# 
#     #send.py
#     import sys
#     message = ' '.join(sys.argv[1:]) or "Hello World..."
#     channel.basic_publish(exchange='', routing_key='hello', body=message)
#     print "[x] Send %r" % message
# 
#     #receive.py
#     import time
#     def callback(ch, method, properties, body):
#         print "[x] Received %r" % (body,)
#         time.sleep(body.count('.'))
#         print "[x] Done"


# 
#     def callback(ch, method, properties, body):
#         print "[x] Received %r" % (body,)
#         time.sleep(body.count('.'))
#         print "[x] Done"
#         ch.basic_ack(delivery_tag=method.delivery_tag)
#     channel.basic_consume(callback, queue='hello')

#     channel.queue_declare(queue='task_queue', durable=True)

#     channel.basic_publish(exchange='', routing_key='task_queue', body=message'
#                 properties=pika.BasicProperties(delivery_mode=2,))


#     #send.py
#     #!/usr/bin/env python
#     import pika
#     import sys
# 
#     connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
#     channel = connection.channel()
#     channel.queue_declare(queue='task_queue', durable=True)
# 
#     message = ' '.join(sys.argv[1:]) or "Hello World!"
#     channel.basic_publish(exchange='', routing_key='task_queue', body=message,
#                       properties=pika.BasicProperties(delivery_mode = 2,))
#     print " [x] Sent %r" % (message,)
#     connection.close()
# 
#     #receive.py
#     #!/usr/bin/env python
#     import pika
#     import time
# 
#     def callback(ch, method, properties, body):
#         print " [x] Received %r" % (body,)
#         time.sleep( body.count('.') )
#         print " [x] Done"
#         ch.basic_ack(delivery_tag = method.delivery_tag)
# 
#     connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
#     channel = connection.channel()
#     channel.queue_declare(queue='task_queue', durable=True)
#     channel.basic_qos(prefetch_count=1)
#     channel.basic_consume(callback,queue='task_queue')
# 
#     print ' [*] Waiting for messages. To exit press CTRL+C'
#     channel.start_consuming()
# ��ó:RabbitMQ with Python #2/6 http://killins.egloos.com/3025575


#     channel.exchange_declare(exchange='logs', type='fanout')
#     ...
#     channel.basic_publish(exchange='logs', routing_key='log', body=message)



#     result = channel.queue_declare()
# 
# ���� ���� ť �̸��� ���� �ʰ� ť�� �����ϸ� ���Ŀ�� ���Ƿ� �̸��� �����ϰ� �ǰ�, �̰��� result.method.queue�� �����Ͽ� �� �� �ִ�. ���⼭ ���μ����� ����Ǹ�, �� subscriber�� ������ ������ ť�� �ڵ����� �����Ϸ��� ť�� ������ �� �Ʒ��� ���� exclusive ���ڸ� �ָ� �ȴ�.
# 
#     result = channel.queue_declare(exclusive=True)
# 
# �̷��� ������ ť�� exchange�� �Ʒ��� ���� binding ���ָ� �ȴ�.
# 
#     channel.queue_bind(exchange='logs', queue=result.method.queue)
# ��ó:RabbitMQ with Python #3/6


#    import pika
# 
#     def callback(ch, method, properties, body):
#         print "[x] %r" % (body,)
# 
#     connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
#     channel = connection.channel()
# 
#     channel.exchange_declare(exchange='logs', type='fanout')
#     result = channel.queue_declare(exclusive=True)
#     channel.queue_bind(exchange='logs', queue=result.method.queue)
#     channel.basic_consume(callback, queue=result.method.queue, no_ack=True)
# 
#     print "[*] Waiting for logs. To exit press CTRL+C"
#     channel.start_consuming()
# ��ó:RabbitMQ with Python #3/6 http://killins.egloos.com/3025762

