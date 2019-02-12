import * as express from '';

export const app = express();

app.get('/', (request, response) => {
    let query = request.query.q;
    console.log(`Query is: ${query}`);
    response.send(query || 'Hello!');
});