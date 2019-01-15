from app import app
from flask import request


@app.route('/')
def index():
    query = request.args.get('q')
    print("Query is: ", query)
    return 'Hello, World!'
