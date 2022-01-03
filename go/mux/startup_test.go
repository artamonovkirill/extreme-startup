package main

import (
	"bytes"
	"gotest.tools/assert"
	"net/http"
	"net/http/httptest"
	"testing"
)

func TestParsesQuery(t *testing.T) {
	// given:
	router := Router()
	server := httptest.NewServer(router)
	defer server.Close()

	// when:
	response, err := http.Get(server.URL + "?q=bar")

	// then:
	assert.NilError(t, err)
	assert.Equal(t, response.StatusCode, http.StatusOK)
	assert.Equal(t, body(response), "bar")
}

func body(response *http.Response) string {
	buffer := new(bytes.Buffer)
	if _, err := buffer.ReadFrom(response.Body); err != nil {
		panic(err)
	}
	return buffer.String()
}
