from flask import request
from startup import app


@app.route('/')
def index():
    query = request.args.get('q')
    print('Query is: ', query)
    return 'Hello' if query is None else query
