# data-structures-implementation
# Consumer Producer
# Thread Pool
# Delayed queue
        
        blocking + priority queue
        
        Q: What are the use cases of delayed queue?
        - Programming with eventual consistency model in distributed applications/systems.
        - Add a delay between two activities
            - In Uber, if riders don’t pay within 7 days, send over the money to drivers directly.
            - Orders, when the order is over 10 minutes unpaid, the goods in the shopping cart are automatically released, and the order is invalid.

        Q: How delayed queue is implemented?

        DelayQueue is a specialized PriorityQueue that orders elements based on their delay time. link

        When delay hasn’t expired, the message in queue is can’t be taken.
        The head of the queue is the element whose delay expired furthest in the past.


        # Delayed queue



