from flask import Flask
from flask_restful import reqparse, abort, Api, Resource
from speaker.flaskr.url import API
import py_eureka_client.eureka_client as eureka_client
