from flask import Flask
from flask_restful import reqparse, abort, Api, Resource
from mic.flaskr.url import API
import py_eureka_client.eureka_client as eureka_client
