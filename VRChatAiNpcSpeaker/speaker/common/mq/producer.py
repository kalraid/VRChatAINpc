import pika

EXCHANGE_NAME = "cafe.topic";
QUEUE_NAME = "coffee.queue";
ROUTING_KEY = "order.coffee.#";

connection = pika.BlockingConnection(pika.ConnectionParameters(host='http://192.168.255.128:15672'));
channel = connection.channel();

channel.queue_declare(queue = QUEUE_NAME);

channel.basic_publish(exchange=EXCHANGE_NAME, routing_key=ROUTING_KEY, body='Hello World!');
print(" [x] Sent 'Hello World!'");
connection.close()



#     import pika
#     import sys
# 
#     connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
#     channel = connection.channel()
# 
#     channel.exchange_declare(exchange='logs', type='fanout')
# 
#     message = ' '.join(sys.argv[1:]) or "Logs..."
#     channel.basic_publish(exchange='logs', routing_key='key', body=message)
#     print "[x] Send %r" % (message,)
#     connection.close()
# ��ó:RabbitMQ with Python #3/6