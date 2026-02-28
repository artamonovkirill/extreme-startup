import { describe, it } from 'node:test';
import request from 'supertest';

import {app} from "./app";

describe('App', () => {
    it('exposes root endpoint', async () => {
        await request(app)
            .get('/')
            .expect('Hello!');
    });
    it('returns query if given', async () => {
        await request(app)
            .get('/?q=foo')
            .expect('foo');
    });
});
