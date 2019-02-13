import pytest

from . import app


@pytest.fixture
def client():
    app.config['TESTING'] = True
    return app.test_client()


def test_query_endpoint_handles_no_query(client):
    response = client.get('/')
    assert b'Hello' in response.data


def test_query_endpoint(client):
    response = client.get('/?q=foo')
    assert b'foo' in response.data
