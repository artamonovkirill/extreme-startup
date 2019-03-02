require 'sinatra'

get '/' do
  query = params[:q]
  print query
  query || 'Hello!'
end