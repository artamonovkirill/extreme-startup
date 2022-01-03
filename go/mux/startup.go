package main

import (
	"fmt"
	"github.com/gorilla/mux"
	"net/http"
)

func main() {
	router := Router()
	port := "12345"
	fmt.Println("Listening on port:", port)
	if err := http.ListenAndServe(":"+port, router); err != nil {
		panic(err)
	}
}

func Router() *mux.Router {
	var router *mux.Router
	router = mux.NewRouter()
	router.PathPrefix("/").HandlerFunc(answer).Methods("GET")
	return router
}

func answer(response http.ResponseWriter, request *http.Request) {
	query := request.URL.Query()
	q := query["q"][0]
	if _, err := response.Write([]byte(q)); err != nil {
		panic(err)
	}
}
