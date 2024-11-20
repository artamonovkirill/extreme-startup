require 'sinatra'

configure do
  set :host_authorization, :permitted_hosts => nil
end

get '/' do
  query = params[:q]
  print query
  query || 'Hello!'
end