-- Fetch all products in the 'Electronics' category.
select p.name, c.category_name from products p
join categories c on p.category_id = c.category_id
where c.category_name = 'Electronics';

-- Find all orders placed by 'alice'.
select * from orders o
join users u on o.user_id = u.user_id
where u.username = 'alice';

-- List all distinct payment methods used.
select distinct(p.payment_method) from payments p;

-- Get the most expensive product.
select p.name from products p
order by price desc limit 1;

-- Retrieve products with stock greater than 50.
select * from products p where p.stock > 50;

-- List products that have not been ordered.
select p.name, oi.product_id from products p
left join order_items oi on p.product_id = oi.product_id
where oi.product_id is null;

select p.name from products p where p.product_id not in (select distinct(oi.product_id) from order_items oi);

-- Retrieve the total number of orders per user.
select u.username, count(o.user_id) from users u
left join orders o on u.user_id = o.user_id
group by u.username;

-- Find users who have made more than 1 order.
select u.username, count(o.user_id) from orders o
join users u on o.user_id = u.user_id
-- where o.status = 'Delivered'
group by u.username
having count(o.user_id) > 1;

-- Get the total amount spent by each user.
select u.username, coalesce(sum(o.total_price),0) from users u
left join orders o on u.user_id = o.user_id
group by u.username;

-- Find the most popular product (ordered most times).
select p.name,sum(oi.quantity) as total_no_of_orders from order_items oi
join products p on oi.product_id = p.product_id
group by oi.product_id 
order by total_no_of_orders desc limit 1;

-- Find the total number of products sold per category.
select c.category_name, coalesce(sum(oi.quantity),0) as total_no_of_product_sold from categories c
left join products p on c.category_id = p.category_id
left join order_items oi on p.product_id = oi.product_id
group by c.category_name;

SELECT c.category_name, SUM(oi.quantity) AS total_sold 
FROM Order_Items oi 
JOIN Products p ON oi.product_id = p.product_id
right JOIN Categories c ON p.category_id = c.category_id
GROUP BY c.category_name;

-- List all orders along with user details.
select * from orders o 
join users u on o.user_id = u.user_id;

-- Retrieve the highest spending user
select u.username, sum(o.total_price) as total_price from orders o
join users u on o.user_id = u.user_id
group by o.user_id
order by total_price desc limit 1;

-- Find users who have never placed an order.
select u.username, o.order_id from users u
left join orders o on u.user_id = o.user_id
where o.user_id is null;

-- List all orders that have at least one item with a price greater than $100
select oi.order_id,count(*) from order_items oi
where oi.price > 100
group by oi.order_id;

select distinct o.* from order_items oi
join orders o on oi.order_id = o.order_id
where oi.price >100;

-- Find the most frequently used payment method.
select p.payment_method, count(p.payment_method) as no_of_used from  payments p
group by p.payment_method
order by no_of_used desc
limit 1;






