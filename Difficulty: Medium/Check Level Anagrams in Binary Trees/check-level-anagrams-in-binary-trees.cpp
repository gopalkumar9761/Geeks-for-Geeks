class Solution {
  public:
    bool areAnagrams(Node *root1, Node *root2) {
        if (root1 == NULL && root2 == NULL) return true;
        if (root1 == NULL || root2 == NULL) return false;

        queue<Node*> q1, q2;
        q1.push(root1);
        q2.push(root2);

        while (!q1.empty() && !q2.empty()) {
            int n1 = q1.size();
            int n2 = q2.size();

            if (n1 != n2) return false;

            unordered_map<int, int> map1, map2;

            for (int i = 0; i < n1; i++) {
                Node* node1 = q1.front(); q1.pop();
                Node* node2 = q2.front(); q2.pop();

                map1[node1->data]++;
                map2[node2->data]++;

                if (node1->left) q1.push(node1->left);
                if (node1->right) q1.push(node1->right);

                if (node2->left) q2.push(node2->left);
                if (node2->right) q2.push(node2->right);
            }

            if (map1 != map2) return false;
        }

        return q1.empty() && q2.empty();
    }
};