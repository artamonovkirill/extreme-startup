import * as request from 'supertest';

import {app} from "./app";

describe('App', () => {
    it('exposes root endpoint', done => {
        request(app)
            .get('/')
            .expect('Hello!')
            .end(done);
    });
    it('returns query if given', done => {
        request(app)
            .get('/?q=foo')
            .expect('foo')
            .end(done);
    });
});