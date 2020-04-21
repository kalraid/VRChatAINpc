import pika

EXCHANGE_NAME = "cafe.topic";
QUEUE_NAME = "coffee.queue";
ROUTING_KEY = "order.coffee.#";

def callback(ch, method, properties, body):
    print(" [x] Received %r" % (body))

connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'));
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
# 출처:RabbitMQ with Python #2/6 http://killins.egloos.com/3025575


#     channel.exchange_declare(exchange='logs', type='fanout')
#     ...
#     channel.basic_publish(exchange='logs', routing_key='log', body=message)



#     result = channel.queue_declare()
# 
# 위와 같이 큐 이름을 주지 않고 큐를 생성하면 브로커가 임의로 이름을 생성하게 되고, 이것은 result.method.queue로 접근하여 알 수 있다. 여기서 프로세스가 종료되면, 즉 subscriber가 연결을 끊으면 큐를 자동으로 제거하려면 큐를 생성할 때 아래와 같이 exclusive 인자를 주면 된다.
# 
#     result = channel.queue_declare(exclusive=True)
# 
# 이렇게 생성한 큐를 exchange에 아래와 같이 binding 해주면 된다.
# 
#     channel.queue_bind(exchange='logs', queue=result.method.queue)
# 출처:RabbitMQ with Python #3/6


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
# 출처:RabbitMQ with Python #3/6 http://killins.egloos.com/3025762

