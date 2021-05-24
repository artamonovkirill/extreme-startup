import * as express from 'express';
import {Request, Response} from 'express';

export const app = express();

app.get('/', (request: Request, response: Response) => {
    let query = request.query.q;
    console.log(`Query is: ${query}`);
    response.send(query || 'Hello!');
});