require_relative 'extreme_startup'
require 'minitest/autorun'
require 'rack/test'

class ExtremeStartupTest < Minitest::Test
  include Rack::Test::Methods

  def app
    Sinatra::Application
  end

  def test_no_query
    get '/'
    assert_equal 'Hello!', last_response.body
  end

  def test_with_query
    get '/?q=foo'
    assert_equal 'foo', last_response.body
  end
end